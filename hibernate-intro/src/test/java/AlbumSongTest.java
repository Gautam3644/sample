import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.lti.entity.Album;
import com.lti.entity.Song;
import com.lti.entity.dao.GenericDao;

public class AlbumSongTest {

	@Test
	public void addSomeAlbums() {
		GenericDao dao = new GenericDao();
		
		Album alb = new Album();
		alb.setName("RDB");
		alb.setReleaseDate(LocalDate.of(2000, 1, 1));
		alb.setCopyright("Sony");
		dao.save(alb);
	}
	
	@Test
	public void addSongToAlbum() {
		GenericDao dao = new GenericDao();
		Album alb =(Album) dao.fetch(Album.class, 126);
		
		Song song = new Song();
		song = new Song();
		song.setTitle("Pyar Deewana Hota hai");
		song.setDuration(5.00);
		song.setArtist("Kishore Kumar");
		song.setAlbum(alb);
		dao.save(song);
		
	}
	
	@Test
	public void addAlbumAlongWithSongs() {
		GenericDao dao = new GenericDao();
		
		Album album = new Album();
		album.setName("Bolly Retro");
		album.setCopyright("Mastana");
		album.setReleaseDate(LocalDate.of(2000, 1, 2));
		
		List<Song> songs = new ArrayList<Song>();
		
		Song s1 = new Song();
		s1.setTitle("Mera Juta Hai Jaapani");
		s1.setArtist("Mukesh");
		s1.setDuration(5.00);
		s1.setAlbum(album);
		
		Song s2 = new Song();
		s2.setTitle("Chalte Chalte");
		s2.setArtist("Kishore");
		s2.setDuration(5.00);
		s2.setAlbum(album);
		
		songs.add(s1);
		songs.add(s2);
		album.setSongs(songs);
		
		dao.save(album);
		
	}
	
}
