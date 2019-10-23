package com.sunny.grokkingalgorithms.boot2019.yelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class User{
    public String name;

    public User(String name, String team) {
        this.name = name;
        this.team = team;
    }

    public String team;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", team='" + team + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) &&
                Objects.equals(team, user.team);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, team);
    }
}
class Match{
    @Override
    public String toString() {
        return "Match{" +
                "first='" + first + '\'' +
                ", second='" + second + '\'' +
                '}';
    }

    public Match(String first, String second) {
        this.first = first;
        this.second = second;
    }

    public String first;
    public String second;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Match match = (Match) o;
        return Objects.equals(first, match.first) &&
                Objects.equals(second, match.second);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getSecond() {
        return second;
    }

    public void setSecond(String second) {
        this.second = second;
    }
}
public class GenerateUniqueMatches {


    public static List<Match> findMatches(List<User> users){
        List<Match> matches = new ArrayList<>();
        int i = 0;
        int j = users.size() - 1;
        while(i < users.size()/2){
            Match match = new Match(users.get(i).name,users.get(j).name);
            matches.add(match);
            i++;
            j--;
        }
        if(users.size()%2 != 0){
            Match match = new Match(users.get(i).name,null);
            matches.add(match);
        }
        return matches;
    }

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        User sunny = new User("sunny","blue");
        User abhijeet = new User("abhijeet","yellow");
        User kunal = new User("kailash","red");
        User suresh = new User("suresh", "blue");
        User ramesh = new User("ramesh","yellow");
        users.add(sunny);
        users.add(abhijeet);
        users.add(kunal);
        users.add(suresh);
        users.add(ramesh);
        System.out.println(findMatches(users));
        users.add(new User("kamlesh","yellow"));
        System.out.println(findMatches(users));
    }

}
