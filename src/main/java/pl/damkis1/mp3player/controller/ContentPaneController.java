package pl.damkis1.mp3player.controller;

import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.farng.mp3.MP3File;
import org.farng.mp3.TagException;
import org.farng.mp3.id3.AbstractID3v2;
import pl.damkis1.mp3player.mp3.Mp3Song;

import java.io.File;
import java.io.IOException;

public class ContentPaneController {
    private static final String TITLE_COLUMN = "Tytuł";
    private static final String AUTHOR_COLUMN = "Autor";
    private static final String ALBUM_COLUMN = "Album";

    @FXML
    private TableView<Mp3Song> contentTable;

    public void initialize() throws TagException, IOException {
        configureTableColumns();
        createTestData();
    }

    private void configureTableColumns(){
        TableColumn<Mp3Song, String> titleColumn = new TableColumn<Mp3Song, String>(TITLE_COLUMN);
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));

        TableColumn<Mp3Song, String> authorColumn = new TableColumn<Mp3Song, String>(AUTHOR_COLUMN);
        authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));

        TableColumn<Mp3Song, String> albumColumn = new TableColumn<Mp3Song, String>(ALBUM_COLUMN);
        albumColumn.setCellValueFactory(new PropertyValueFactory<>("album"));

        contentTable.getColumns().add(titleColumn);
        contentTable.getColumns().add(authorColumn);
        contentTable.getColumns().add(albumColumn);

    }

    private void createTestData(){
        ObservableList<Mp3Song> item = contentTable.getItems();
        Mp3Song mp3Song = createMp3SongFromPath("test.mp3");
        item.add(mp3Song);
    }

    private Mp3Song createMp3SongFromPath(String path){
        File sourceFile = new File(path);
        try {
            MP3File mp3file = new MP3File(sourceFile);
            String title = mp3file.getID3v2Tag().getAlbumTitle();
            String author = mp3file.getID3v2Tag().getAuthorComposer();
            String album = mp3file.getID3v2Tag().getAlbumTitle();
            String absolutPath = sourceFile.getAbsolutePath();
            return new Mp3Song(title, author, album, absolutPath);
        } catch (IOException | TagException e) {
            throw new RuntimeException(e);
        }
    }
}
