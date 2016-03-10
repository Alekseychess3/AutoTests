package pages;

/**
 * Created by Aleksey on 09.03.2016.
 */
public abstract class Page {


    protected string url="";
    public Page(string url){
        this.url=url;
    }

    public abstract void fillingFields();

    public abstract void steps();

    public abstract string currentResult();

    public abstract string expectedResult();

}
