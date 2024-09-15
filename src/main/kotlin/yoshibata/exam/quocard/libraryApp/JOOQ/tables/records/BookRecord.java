/*
 * This file is generated by jOOQ.
 */
package yoshibata.exam.quocard.libraryApp.JOOQ.tables.records;


import java.time.LocalDateTime;

import org.jooq.Record1;
import org.jooq.impl.UpdatableRecordImpl;

import yoshibata.exam.quocard.libraryApp.JOOQ.tables.Book;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class BookRecord extends UpdatableRecordImpl<BookRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>library_app_schema.book.id</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>library_app_schema.book.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>library_app_schema.book.title</code>.
     */
    public void setTitle(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>library_app_schema.book.title</code>.
     */
    public String getTitle() {
        return (String) get(1);
    }

    /**
     * Setter for <code>library_app_schema.book.created_at</code>.
     */
    public void setCreatedAt(LocalDateTime value) {
        set(2, value);
    }

    /**
     * Getter for <code>library_app_schema.book.created_at</code>.
     */
    public LocalDateTime getCreatedAt() {
        return (LocalDateTime) get(2);
    }

    /**
     * Setter for <code>library_app_schema.book.updated_at</code>.
     */
    public void setUpdatedAt(LocalDateTime value) {
        set(3, value);
    }

    /**
     * Getter for <code>library_app_schema.book.updated_at</code>.
     */
    public LocalDateTime getUpdatedAt() {
        return (LocalDateTime) get(3);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached BookRecord
     */
    public BookRecord() {
        super(Book.BOOK);
    }

    /**
     * Create a detached, initialised BookRecord
     */
    public BookRecord(Integer id, String title, LocalDateTime createdAt, LocalDateTime updatedAt) {
        super(Book.BOOK);

        setId(id);
        setTitle(title);
        setCreatedAt(createdAt);
        setUpdatedAt(updatedAt);
        resetChangedOnNotNull();
    }
}
