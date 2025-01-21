package countryhandler;

public class Country {

    private String nation;
    private String capital;
    private String language;
    private String currency;
    private boolean isItIsland;
    private int numberOfPeople;

    public Country (){}

    public Country(String nation, String capital, String language, String currency, boolean isItIsland, int numberOfPeople) {
        this.nation = nation;
        this.capital = capital;
        this.language = language;
        this.currency = currency;
        this.isItIsland = isItIsland;
        this.numberOfPeople = numberOfPeople;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }
    
    public String getCapital() {
        return capital;
    }
    public void setCapital(String capital) {
        this.capital = capital;
    }
    public String getLanguage() {
        return language;
    }
    public void setLanguage(String language) {
        this.language = language;
    }
    public String getCurrency() {
        return currency;
    }
    public void setCurrency(String currency) {
        this.currency = currency;
    }
    public boolean isItIsland() {
        return isItIsland;
    }
    public void setItIsland(boolean isItIsland) {
        this.isItIsland = isItIsland;
    }
    public int getNumberOfPeople() {
        return numberOfPeople;
    }
    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    @Override
    public String toString() {
        return "Country: " + this.nation + " capital=" + this.capital + ", language=" + this.language + ", currency=" + this.currency + ", isItIsland="
                + this.isItIsland + ", numberOfPeople=" + this.numberOfPeople;
    }

    public String getFormattedElement()
    {
        return this.nation + "," + this.capital + "," + this.language + "," + this.currency + "," + this.isItIsland + "," + this.numberOfPeople + ",";
    }
}

