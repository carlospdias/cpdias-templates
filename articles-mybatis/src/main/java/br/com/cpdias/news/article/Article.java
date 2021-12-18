package br.com.cpdias.news.article;

public class Article {
    private String id;
    private String link;
    private String title;
    private String resume;
    private String content;

    public Article(String id, String title) {
        this.id = id;
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Articles{" +
                "id='" + id + '\'' +
                ", link='" + link + '\'' +
                ", title='" + title + '\'' +
                ", resume='" + resume + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}