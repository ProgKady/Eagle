// MP3MetadataUtil.java
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;

import java.io.File;

public class MP3MetadataUtil {

    public static String getArtist(File mp3File) {
        try {
            AudioFile file = AudioFileIO.read(mp3File);
            Tag tag = file.getTag();
            if (tag != null) {
                String artist = tag.getFirst(FieldKey.ARTIST);
                return artist.isEmpty() ? "Unknown Artist" : artist;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Unknown Artist";
    }

    public static String getTitle(File mp3File) {
        try {
            AudioFile file = AudioFileIO.read(mp3File);
            Tag tag = file.getTag();
            if (tag != null) {
                String title = tag.getFirst(FieldKey.TITLE);
                return title.isEmpty() ? stripExtension(mp3File.getName()) : title;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stripExtension(mp3File.getName());
    }

    private static String stripExtension(String name) {
        return name.contains(".") ? name.substring(0, name.lastIndexOf('.')) : name;
    }
}
