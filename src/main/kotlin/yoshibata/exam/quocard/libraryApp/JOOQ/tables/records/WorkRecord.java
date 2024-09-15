/*
 * This file is generated by jOOQ.
 */
package yoshibata.exam.quocard.libraryApp.JOOQ.tables.records;


import org.jooq.Record2;
import org.jooq.impl.UpdatableRecordImpl;

import yoshibata.exam.quocard.libraryApp.JOOQ.tables.Work;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class WorkRecord extends UpdatableRecordImpl<WorkRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>library_app_schema.work.book_id</code>.
     */
    public void setBookId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>library_app_schema.work.book_id</code>.
     */
    public Integer getBookId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>library_app_schema.work.author_id</code>.
     */
    public void setAuthorId(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>library_app_schema.work.author_id</code>.
     */
    public Integer getAuthorId() {
        return (Integer) get(1);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record2<Integer, Integer> key() {
        return (Record2) super.key();
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached WorkRecord
     */
    public WorkRecord() {
        super(Work.WORK);
    }

    /**
     * Create a detached, initialised WorkRecord
     */
    public WorkRecord(Integer bookId, Integer authorId) {
        super(Work.WORK);

        setBookId(bookId);
        setAuthorId(authorId);
        resetChangedOnNotNull();
    }
}
