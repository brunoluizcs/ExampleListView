package examplelistview.com.bomcodigo.examplelistview;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bomcodigo.com
 */
public class SuperHeroHelper {

    public SuperHeroHelper() {
    }

    private SuperHero getSuperHero(String superName, String realName, String publisher){
        SuperHero superHero = new SuperHero();
        superHero.setSuperName(superName);
        superHero.setRealName(realName);
        superHero.setPublisher(publisher);

        return superHero;
    }

    public List<SuperHero> getSuperHeroList(){
        List<SuperHero> list = new ArrayList<>();
        list.add(getSuperHero("Superman","Kal-El / Clark Joseph Kent","DC Comics"));
        list.add(getSuperHero("Batman","Bruce Wayne","DC Comics"));
        list.add(getSuperHero("Spider-Man","Peter Benjamin Parker","Marvel"));
        list.add(getSuperHero("Thor","Thor Odinson","Marvel"));
        list.add(getSuperHero("Wonder Woman","Diana of Themyscira","DC Comics"));
        list.add(getSuperHero("Captain America","Steven Rogers","Marvel"));
        list.add(getSuperHero("Wolverine","James Howlett","Marvel"));
        list.add(getSuperHero("Black Panther","T'Challa","Marvel"));

        return list;
    }


}
