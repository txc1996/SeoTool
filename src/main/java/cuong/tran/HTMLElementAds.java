package cuong.tran;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HTMLElementAds implements HTMLElement {

    @Override
    public List<Card> getCards(String url, String keyWord) throws Exception{
        List<Card> cards = new ArrayList<>();
        Document doc;
            doc = Jsoup.connect(url).get();

            Element mainDiv = doc.getElementById("main");
            Element cnt = mainDiv.getElementById("cnt");
            Elements mvs = cnt.getElementsByClass("mw");
            Element rcnt = null;
            for (Element mv: mvs) {
                rcnt = mv.getElementById("rcnt");
                if(rcnt != null){
                    break;
                }

            }
            Elements cols = rcnt.getElementsByClass("col");
            Element col_center = null;
            for (Element col: cols) {
                col_center = col.getElementById("center_col");
                if(col_center != null){
                    break;
                }

            }


            Element taw = col_center.getElementById("taw");
            Element tvcap = taw.getElementById("tvcap");
            Element tag = tvcap.getElementById("tads");
            if(tag == null){
                return new ArrayList<>();
            }
            Elements ols = tag.getElementsByTag("ol");
            Element ol = ols.first();
            Elements lis = ol.getElementsByClass("ads-ad");

            for (Element li: lis) {
                SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
                Card card = new Card();
                card.setTitle(li.getElementsByClass("ad_cclk").first().text());
                card.setLink(li.getElementsByClass("ads-visurl").text().substring(2));
                card.setDescription(li.getElementsByClass("ellip ads-creative").text());
                card.setMoreInfo(li.getElementsByClass("_yEo").text());
                card.setKeyWork(keyWord);
                card.setCreatedTime(sdf.format(new Date()));
                cards.add(card);
            }

            Element bottomads = col_center.getElementById("bottomads");
            if(bottomads != null){
                Element tadsb = bottomads.getElementById("tadsb");
                Elements olsbottom = tadsb.getElementsByTag("ol");
                Element olbottomFirst = olsbottom.first();
                Elements lisbottom = olbottomFirst.getElementsByClass("ads-ad");
                for (Element li: lisbottom) {
                    SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
                    Card card = new Card();
                    card.setTitle(li.getElementsByClass("ad_cclk").first().text());
                    card.setLink(li.getElementsByClass("ads-visurl").text().substring(2));
                    card.setDescription(li.getElementsByClass("ellip ads-creative").text());
                    card.setMoreInfo(li.getElementsByClass("ellip").text());
                    card.setKeyWork(keyWord);
                    card.setCreatedTime(sdf.format(new Date()));
                    cards.add(card);
                }
            }
        return cards;
    }
}
