package BandSection;

import java.util.Objects;

import ShortySection.ShortyMusician;
import StreetSection.Street;

public class Orchestra {

    public int count_of_members;
    protected String type_music;
    public boolean type_local;
    public boolean popularity;

    public Orchestra(int count_of_members, String type_music, boolean type_local, boolean popularity) {

        this.count_of_members = count_of_members;
        this.type_music = type_music;
        this.type_local = type_local;
        this.popularity = popularity;
        
    }

    public void playMusic(String nameGroup, ShortyMusician[] stackShorty, boolean localStatus, int countMembersStatus, boolean popularityStatus) {

        System.out.println(nameGroup + " начинаем играть жесткий " + type_music);

        for (int i = 0; i < stackShorty.length; ++i)
        {
            if (stackShorty[i].drunk)
            {

                stackShorty[i].cry(nameGroup);

            } else if (!stackShorty[i].drunk)
            {

                stackShorty[i].play_an_instrument(nameGroup);

            }
        }

        callTheCroud(nameGroup, localStatus, countMembersStatus, popularityStatus);

    }

    public void goTo(Street[] streets) {}

    public void fellGroup(String nameGroup) {System.out.println("Группа " + nameGroup + " распалась!\n");}

    public void celebrate(String nameGroup) {System.out.println("Группа " + nameGroup + " празднует!\n");}

    public void callTheCroud(String nameGroup, boolean localStatus, int countMembersStatus, boolean popularityStatus) {

        System.out.println("Собирается толпа фанатов");

        // local(true) -> 0.2 | countMembers * 0.05 -> max 0.5 | popularity(trye) -> 0.3 |||||| Если >= 0.6 то толпа остается

        float num = 0;
        if (localStatus) {num += 0.2;}
        if (popularity) {num += 0.3;}
        num += countMembersStatus*0.05;

        if (num >= 0.6)
        {

            System.out.println("Ура, толпа у группы " + nameGroup + " остается");
            celebrate(nameGroup);

            try 
            {
                Thread.sleep(1500);
            } catch (InterruptedException e) 
            {
                System.out.println("Задержка прервана!");
            }

        } else 
        {

            System.out.println("Толпа уходит от группы " + nameGroup);
            fellGroup(nameGroup);

            try 
            {
                Thread.sleep(1500);
            } catch (InterruptedException e) 
            {
                System.out.println("Задержка прервана!");
            }

        }

    }

    @Override
    public boolean equals(Object obj) 
    {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Orchestra other = (Orchestra)obj;
        return (this.count_of_members == other.count_of_members) && this.type_music.equals(other.type_music) && (this.type_local == other.type_local) && (this.popularity == other.popularity); 
    }

    @Override
    public int hashCode() 
    {
        return Objects.hash(count_of_members, type_music, type_local, popularity);
    }


}