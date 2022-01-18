package ru.gb.lesson_11.repositories;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import ru.gb.lesson_11.entities.FileMetaDTO;

import java.util.Collection;
import java.util.UUID;

@Component
public class FileMetaProvider {

    private static final String GET_FILES_META = "select hash, filename from file_info_metadata where subtype = :subtype";

    private static final String GET_FILE_PATH_BY_HASH = "select filename from file_info_metadata where hash = :hash";

    private static final String SAVE_FILE_META_DATA = "insert into file_info_metadata (hash, filename, subtype)\n" +
            "values (:hash, :finame, :subtype)";

    private static final String DELETE_FILE_META_DATA = "delete from file_info_metadata where hash = :hash";

    private Sql2o sql2o;

    @Autowired
    public void setSql2o(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    public FileMetaProvider(@Autowired Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    public String checkFileExists(UUID fileHash) {
        try (Connection connection = sql2o.open()) {
            return connection.createQuery(GET_FILE_PATH_BY_HASH, false)
                    .addParameter("hash", fileHash.toString())
                    .executeScalar(String.class);
        }
    }

    public void saveFileMeta(UUID fileHash, String fileName, int sybType) {
        try (Connection connection = sql2o.open()) {
            connection.createQuery(SAVE_FILE_META_DATA)
                    .addParameter("hash", fileHash.toString())
                    .addParameter("finame", fileName)
                    .addParameter("subtype", sybType)
                    .executeUpdate();
        }
    }

    public Collection<FileMetaDTO> getMetaFiles(int subtype) {
        try (Connection connection = sql2o.open()) {
            return connection.createQuery(GET_FILES_META, false)
                    .addParameter("subtype", subtype)
                    .executeAndFetch(FileMetaDTO.class);
        }
    }

    public void deleteFileMeta(UUID fileHash) {
        try (Connection connection = sql2o.open()) {
            connection.createQuery(DELETE_FILE_META_DATA)
                    .addParameter("hash", fileHash.toString())
                    .executeUpdate();
        }
    }
}