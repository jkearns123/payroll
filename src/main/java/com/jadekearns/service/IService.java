package com.jadekearns.service;

public interface IService <T,ID>{
    T create (T t);
    T update(T t);
    T delete(ID id);
    T read(ID id);
}
