package com.example.dictionary;

import java.io.*;
import java.util.HashMap;

public class wordDictionary {
    HashMap<String,String> wordlist;
    wordDictionary(){
        this.wordlist= new HashMap<>();
    }
    void addWord(String Word,String Meaning){    //adding new word
        wordlist.put(Word,Meaning);
    }
    HashMap<String,String> getWordlist(){
        return wordlist;
    }
    void serializeMap(){
        try{
            FileOutputStream os = new FileOutputStream("wordlist");
            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeObject(wordlist);
            oos.close();
            os.close();
        }
        catch(IOException io){
            io.printStackTrace();
        }
    }
    void deserializeMap(){
        try{
        FileInputStream is = new FileInputStream("wordlist");
        ObjectInputStream ois = new ObjectInputStream(is);
        wordlist = (HashMap<String, String>) ois.readObject();
        }
    catch(IOException io){
        io.printStackTrace();
    }
        catch (ClassNotFoundException ex){
            System.out.println("Class Not Found");
        }
}
}
