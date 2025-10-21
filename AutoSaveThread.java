package com.library.services;

import java.util.List;
import com.library.models.*;

public class AutoSaveThread extends Thread {

    private FileManager fileManager;
    private List<Book> books;
    private List<Member> members;

    public AutoSaveThread(FileManager fileManager, List<Book> books, List<Member> members) {
        this.fileManager = fileManager;
        this.books = books;
        this.members = members;
    }

    @Override
    public void run() {
        while (true) {
            try {
                fileManager.saveAllData(books, members);
                System.out.println("[AutoSave] Data auto-saved in background...");
                Thread.sleep(10000); // every 10 seconds
            } catch (InterruptedException e) {
                System.out.println("[AutoSave] Interrupted, stopping thread.");
                break;
            }
        }
    }
}
