package com.gavin.mapper;

import com.gavin.pojo.Bookstore;
import org.springframework.stereotype.Repository;

@Repository
public interface BookstoreMapper {

    Bookstore selectByBookId(Integer bookid);

    int insertBookselective(Bookstore bookstore);


}