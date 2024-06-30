package com.jrmusics.JRMusics.principal;

import com.jrmusics.JRMusics.models.Artist;
import com.jrmusics.JRMusics.models.ArtistType;
import com.jrmusics.JRMusics.models.Song;
import com.jrmusics.JRMusics.repository.ArtistRepository;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    private final Scanner in = new Scanner(System.in);
    private ArtistRepository repository;

    public Main(ArtistRepository r){
        this.repository = r;
    }

    public void showMenu(){
        int option = -1;
        var menu = """
                1 - Register an artist
                2 - Register an music
                3 - List Musics
                4 - Find a song by artist name
                
                0 - Exit
                """;

        while(option!=0){
            System.out.println("******JRMusics Options******");
            System.out.println(menu);
            System.out.println("Choose one of the options above: ");

            option = in.nextInt();
            in.nextLine();

            switch (option){
                case 1:
                    registerAnArtist();
                    break;
                case 2:
                    registerAnSong();
                    break;
                case 3:
                    listSongs();
                    break;
                case 4:
                    findSongByArtistName();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Choose a valid option!");
            }
        }
    }

    private void findSongByArtistName() {
        System.out.println("Enter the artist name: ");
        var artistName = in.nextLine();

        Optional<Artist> artist = repository.findByNameContainingIgnoreCase(artistName);
        artist.ifPresent(value -> value.getMusicsList().forEach(System.out::println));
    }

    private void listSongs() {
        List<Artist> artistList = repository.findAll();
        artistList.forEach(System.out::println);
    }

    private void registerAnSong() {
        System.out.println("Enter the artist of this song: ");
        var artistName = in.nextLine();

        Optional<Artist> artist = repository.findByNameContainingIgnoreCase(artistName);
        if(artist.isPresent()){
            System.out.println("What is the name of this song?");
            var songName = in.nextLine();
            Song song = new Song(songName, artist.get());
            artist.get().getMusicsList().add(song);

            repository.save(artist.get());
        }else{
            System.out.println("Artist not found");
        }
    }

    private void registerAnArtist(){
        var respost = "S";

        while(respost.equalsIgnoreCase("s")) {
            Artist newArtist = new Artist();

            System.out.println("Insert the artist name: ");
            String artistName = in.nextLine();

            System.out.println("The artist is works SOLO, PAIR or in a BAND?");
            String artistType = in.nextLine();
            ArtistType artistTypeEm = ArtistType.fromString(artistType);

            newArtist.setName(artistName);
            newArtist.setType(artistTypeEm);

            repository.save(newArtist);
            System.out.println("Register this new artist?(S/N)");
            respost = in.nextLine();
        }
    };
}
