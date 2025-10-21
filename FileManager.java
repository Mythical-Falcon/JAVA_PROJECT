package com.library.services;

import java.io.*;
import java.util.List;
import com.library.models.*;

public class FileManager {

    private static final String BOOK_FILE = "books.dat";
    private static final String MEMBER_FILE = "members.dat";

    // Save both lists
    public void saveAllData(List<Book> books, List<Member> members) {
        saveToFile(BOOK_FILE, books);
        saveToFile(MEMBER_FILE, members);
    }

    // Generic save method
    public void saveToFile(String filename, Object data) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(data);
            System.out.println("[FileManager] " + filename + " saved successfully.");
        } catch (IOException e) {
            System.out.println("[FileManager] Error saving " + filename + ": " + e.getMessage());
        }
    }

    // Generic load method
    public Object loadFromFile(String filename) {
        File file = new File(filename);
        if (!file.exists()) return null;

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            Object data = in.readObject();
            System.out.println("[FileManager] " + filename + " loaded successfully.");
            return data;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("[FileManager] Error loading " + filename + ": " + e.getMessage());
            return null;
        }
    }
}
