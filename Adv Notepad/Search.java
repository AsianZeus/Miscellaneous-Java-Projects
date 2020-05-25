import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.net.URLEncoder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Search {

	public static String getDef(String stext) throws IOException
	{
		String res="";
		try {
		Document doc = Jsoup.connect("http://services.aonaware.com/DictService/Default.aspx?action=define&dict=*&query="+stext).get();
		Elements body = doc.select("span#lblDefinition");
		res= body.get(0).getElementsByTag("p").next().text();
		if(res.equals("")) 
		{
			res="No definitions found for "+stext;
		}
		return res;
		}
		catch(Exception e) 
		{
			res="Poor Internet Connection";
			return res;
		}
	}
	
}

