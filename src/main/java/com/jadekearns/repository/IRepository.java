package com.jadekearns.repository;

public interface IRepository <T,ID>{
    T create (T t);
    T update(T t);
    T delete(ID id);
    T read(ID id);
}
