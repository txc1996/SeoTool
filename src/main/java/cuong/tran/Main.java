package cuong.tran;

import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {
      FileReader excelReader = new ExcelReader();
      FileWriter excelWriter = new ExcelWriter();
      HTMLElement htmlElementAds = new HTMLElementAds();


      //read data from excel file
      List<String> keyWordList = new ArrayList<>();

      try {
          keyWordList = excelReader.readFromFile(Const.NAME_INPUT_FILE+Const.TYPE_OF_FILE);
      } catch (Exception e) {
          System.out.println("ERROR: Please close the data file and try again");
      }

      //get adds card
      List<Card> cardList = new ArrayList<>();
      for (String keyWord: keyWordList) {
          String searchKeyWord = keyWord.replace(" ", "+");
          try {
              List<Card> cards = htmlElementAds.getCards(Const.SEARCH_URL+"?q="+searchKeyWord, searchKeyWord);
              //no need to get card already in List
              for(Card cardMain : cardList){
                  for(Card card: cards){
                      if(cardMain.getTitle().equals(card.getTitle()) && cardMain.getTitle().equals(card.getTitle())){
                          cards.remove(card);
                      }
                  }
              }
              //just add when have adds
              if(!cards.isEmpty()){
                  cardList.addAll(cards);
              }else{
                  System.out.println(keyWord+ " have been searched or have no adds");
              }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("No adds for "+keyWord);
            }
        }

        //write data into excel file
        if(!cardList.isEmpty()){
            try {
                excelWriter.writeToFile(cardList, Const.NAME_OUTPUT_FILE+Const.TYPE_OF_FILE);
            } catch (Exception e) {
                System.out.println("ERROR: Please close the outPutData file and try again");
            }
        }

      }
}