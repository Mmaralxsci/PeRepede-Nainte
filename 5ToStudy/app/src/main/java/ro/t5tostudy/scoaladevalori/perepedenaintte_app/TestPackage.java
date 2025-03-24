package ro.t5tostudy.scoaladevalori.perepedenainte_app;

import java.io.Serializable;

public class TestPackage implements Serializable {

    public String subject;
    public String testteza;
    public String grade;
    public String profile;
    public String chapter;

    public String title;
    public String description;
    public String publisher;

    public String testText;

    public String answerText;

    public String theoryText;

    public TestPackage(String subject, String testteza, String grade, String profile, String chapter,
                       String title, String description, String publisher,
                       String testText, String answerText, String theoryText){
        this.subject = subject;
        this.testteza = testteza;
        this.grade = grade;
        this.profile = profile;
        this.chapter = chapter;

        this.title = title;
        this.description = description;
        this.publisher = publisher;

        this.testText = testText;

        this.answerText = answerText;

        this.theoryText = theoryText;
    }

    public TestPackage(){
        this.subject = null;
        this.testteza = null;
        this.grade = null;
        this.profile = null;
        this.chapter = null;

        this.title = null;
        this.description = null;
        this.publisher = null;

        this.testText = null;

        this.answerText = null;

        this.theoryText = null;
    }

    public String getSubject() {
        return subject;
    }

    public String getTestteza() {
        return testteza;
    }

    public String getGrade() {
        return grade;
    }

    public String getProfile() {
        return profile;
    }

    public String getChapter() {
        return chapter;
    }

    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }
    public String getPublisher() {
        return publisher;
    }

    public String getTestText() {
        return testText;
    }
    public String getAnswerText() {
        return answerText;
    }
    public String getTheoryText() {
        return theoryText;
    }
}