package com.library.services;

import java.io.*;
import java.util.List;

public class FileManager {

    private static final String BOOK_FILE = "books.dat";
    private static final String MEMBER_FILE = "members.dat";
    private static final String TRANSACTION_FILE = "transactions.dat";

    // --- Save any list of objects to file ---
    public static synchronized <T> void saveData(List<T> list, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(list);
            System.out.println("✅ Data saved successfully to " + fileName);
        } catch (IOException e) {
            System.out.println("❌ Error saving data: " + e.getMessage());
        }
    }

    // --- Load list of objects from file ---
    @SuppressWarnings("unchecked")
    public static synchronized <T> List<T> loadData(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return (List<T>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("ℹ️ File not found (" + fileName + "), creating new...");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("❌ Error loading data: " + e.getMessage());
        }
        return new java.util.ArrayList<>();
    }

    // --- BufferedInputStream Example ---
    public static void readUsingBufferedStream(String fileName) {
        try (FileInputStream fin = new FileInputStream(fileName);
             BufferedInputStream bin = new BufferedInputStream(fin)) {
            int i;
            System.out.println("📖 Reading file using BufferedInputStream:");
            while ((i = bin.read()) != -1) {
                System.out.print((char) i);
            }
            System.out.println("\n✅ Done.");
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    // --- FileWriter Example ---
    public static void writeUsingFileWriter(String fileName, String content) {
        try (FileWriter fw = new FileWriter(fileName)) {
            fw.write(content);
            System.out.println("✅ FileWriter wrote data successfully.");
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    // --- FileReader Example ---
    public static void readUsingFileReader(String fileName) {
        try (FileReader fr = new FileReader(fileName)) {
            int i;
            System.out.println("📖 Reading file using FileReader:");
            while ((i = fr.read()) != -1) {
                System.out.print((char) i);
            }
            System.out.println("\n✅ Done reading file.");
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    // --- Delete a file ---
    public static void deleteFile(String fileName) {
        File file = new File(fileName);
        if (file.delete()) {
            System.out.println("🗑️ File deleted successfully: " + fileName);
        } else {
            System.out.println("❌ Failed to delete file: " + fileName);
        }
    }

    // --- Rename a file ---
    public static void renameFile(String oldName, String newName) {
        File oldFile = new File(oldName);
        File newFile = new File(newName);
        if (oldFile.renameTo(newFile)) {
            System.out.println("✅ File renamed from " + oldName + " to " + newName);
        } else {
            System.out.println("❌ File rename failed.");
        }
    }

    // --- Copy data from one file to another (read → write) ---
    public static void copyFile(String source, String destination) {
        try (FileInputStream fin = new FileInputStream(source);
             FileOutputStream fout = new FileOutputStream(destination)) {
            int i;
            while ((i = fin.read()) != -1) {
                fout.write(i);
            }
            System.out.println("✅ Copied " + source + " → " + destination);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    // --- Helper Methods for Each Entity ---
    public static void saveBooks(List<?> books) { saveData(books, BOOK_FILE); }
    public static void saveMembers(List<?> members) { saveData(members, MEMBER_FILE); }
    public static void saveTransactions(List<?> transactions) { saveData(transactions, TRANSACTION_FILE); }

    public static List<?> loadBooks() { return loadData(BOOK_FILE); }
    public static List<?> loadMembers() { return loadData(MEMBER_FILE); }
    public static List<?> loadTransactions() { return loadData(TRANSACTION_FILE); }

    // --- Test all file features ---
    public static void main(String[] args) {
        writeUsingFileWriter("demo.txt", "Hello Java File Handling!");
        readUsingFileReader("demo.txt");

        readUsingBufferedStream("demo.txt");
        copyFile("demo.txt", "copy_demo.txt");
        renameFile("copy_demo.txt", "renamed_demo.txt");
        deleteFile("renamed_demo.txt");
    }
}
