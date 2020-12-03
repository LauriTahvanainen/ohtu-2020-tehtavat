package statistics.matcher;

public class QueryBuilder {

    Matcher currentMatcher;
    
    public QueryBuilder() {
        this.currentMatcher = new All();
    }
    
    public QueryBuilder hasAtLeast(int value, String category) {
        this.currentMatcher = new And(this.currentMatcher, new HasAtLeast(value, category));
        return this;
    }
    
    public QueryBuilder playsIn(String team) {
        this.currentMatcher = new And(this.currentMatcher, new PlaysIn(team));
        return this;
    }
    
    public QueryBuilder hasFewerThan(int value, String category) {
        this.currentMatcher = new And(this.currentMatcher, new HasFewerThan(value, category));
        return this;
    }
    
    public QueryBuilder not(Matcher matcher) {
        this.currentMatcher = new Not(matcher);
        return this;
    }
    
    public Matcher build() {
        return this.currentMatcher;
    }
}
