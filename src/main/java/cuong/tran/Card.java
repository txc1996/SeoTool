package cuong.tran;

import java.util.Date;

public class Card {

    private String title;
    private String link;
    private String description;
    private String moreInfo;
    private String keyWork;
    private String createdTime;

    public Card() {
    }

    public Card(String title, String link, String description, String moreInfo, String keyWork, String createdTime) {
        this.title = title;
        this.link = link;
        this.description = description;
        this.moreInfo = moreInfo;
        this.keyWork = keyWork;
        this.createdTime= createdTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMoreInfo() {
        return moreInfo;
    }

    public void setMoreInfo(String moreInfo) {
        this.moreInfo = moreInfo;
    }

    public String getKeyWork() {
        return keyWork;
    }

    public void setKeyWork(String keyWork) {
        this.keyWork = keyWork;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }
}
