package com.jrmusics.JRMusics.models;

import jakarta.persistence.*;

@Entity
@Table(name = "musics")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String title;

    @ManyToOne
    private Artist artist;

    public Song(){}

    public Song(String name, Artist artist){
        this.title = name;
        this.artist = artist;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    @Override
    public String toString() {
        return "artist=" + artist.getName() +
                ", title='" + title;
    }
}
