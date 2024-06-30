package com.jrmusics.JRMusics.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "artists")
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    @Enumerated(EnumType.STRING)
    private ArtistType type;

    @OneToMany(mappedBy = "artist", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Song> musicsList = new ArrayList<>();

    public Artist(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArtistType getType() {
        return type;
    }

    public void setType(ArtistType type) {
        this.type = type;
    }

    public List<Song> getMusicsList() {
        return musicsList;
    }

    public void setMusicsList(List<Song> musicsList) {
        this.musicsList = musicsList;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", type=" + type +
                ", musicsList=" + musicsList;
    }
}
