package fr.unilasalle.recordlog.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "artist_id")
    private Artist artist;

    private String title;
    private long artistID;
    private String format;
    private String date;
    private String genre;
    private String label;
    private String songsList;
    private String coverLink;
    private String spotifyLink;
}
