import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;

//方式2：改为HashSet实现
public class SingerTest2 {
    @Test
    public void test1() {

        Singer singer1 = new Singer("周杰伦");
        Singer singer2 = new Singer("陈奕迅");

        Song song1 = new Song("双节棍");
        Song song2 = new Song("本草纲目");
        Song song3 = new Song("夜曲");
        Song song4 = new Song("浮夸");
        Song song5 = new Song("十年");
        Song song6 = new Song("孤勇者");

        HashSet h1 = new HashSet();// 放歌手一的歌曲
        h1.add(song1);
        h1.add(song2);
        h1.add(song3);

        HashSet h2 = new HashSet();// 放歌手二的歌曲
        h2.add(song4);
        h2.add(song5);
        h2.add(song6);

        HashMap hashMap = new HashMap();// 放歌手和他对应的歌曲
        hashMap.put(singer1, h1);
        hashMap.put(singer2, h2);

        for (Object obj : hashMap.keySet()) {
            System.out.println(obj + "=" + hashMap.get(obj));
        }
//        陈奕迅=[《十年》, 《孤勇者》, 《浮夸》]
//        周杰伦=[《双节棍》, 《本草纲目》, 《夜曲》]

    }
}

//歌曲
class Song implements Comparable{
    private String songName;//歌名

    public Song() {
        super();
    }

    public Song(String songName) {
        super();
        this.songName = songName;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    @Override
    public String toString() {
        return "《" + songName + "》";
    }

    @Override
    public int compareTo(Object o) {
        if(o == this){
            return 0;
        }
        if(o instanceof Song){
            Song song = (Song)o;
            return songName.compareTo(song.getSongName());
        }
        return 0;
    }


}
//歌手
class Singer implements Comparable{
    private String name;
    private Song song;

    public Singer() {
        super();
    }

    public Singer(String name) {
        super();
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(Object o) {
        if(o == this){
            return 0;
        }
        if(o instanceof Singer){
            Singer singer = (Singer)o;
            return name.compareTo(singer.getName());
        }
        return 0;
    }
}