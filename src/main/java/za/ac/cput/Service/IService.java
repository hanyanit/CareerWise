package za.ac.cput.Service;

public interface IService <T, ID>{
    T create(T t);
    T read(ID id);
    T update(T t);
    boolean delete(ID id);


//    save()
//    findById()
//    findAll()
//    deleteById()

    //we shoild delete this class it forces us to unnecesarry abstraction
}
