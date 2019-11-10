import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

public class Cleaner {
	public static void main(String... args) throws IOException {
		System.out.println("Usage: File absolute path");
		Set<Integer> nonEmptyCols = new HashSet<>();
		String del = args.length > 1 ? args[1] : "";
		String s = Files.lines(Paths.get(args[0]))
			.filter(e -> e.trim().length() > 0 && !e.equals(del))
			.map(e ->  { 
					String[] parts = e.split(",");
					return IntStream.of(0, parts.length - 1)
						.filter(f->parts[f].length() > 0)
						.peek(f -> nonEmptyCols.add(f))
						.mapToObj(f -> parts[f])
						.map(f -> 
								f.startsWith("\"//cdn.") ? 
								"<img src=\"https:"+f.substring(1)+" />" : 
								f
						)
						.map(f -> 
								f.trim().length()>0 && f.startsWith("\"http") ? "<a href="+f+">"+(f.contains("cdn") ? 
									"pic" :
									"link"
							)+"</a>" : 
						f)
						.collect(Collectors.joining("</td><td>", "<tr><td>", "</td></tr>"));
				   }
			)
			.collect(Collectors.joining("", "<table border=1>", "</table>"));
		System.out.println(s);
		System.out.println("nonEmptyCols:" + nonEmptyCols);
	}
}
