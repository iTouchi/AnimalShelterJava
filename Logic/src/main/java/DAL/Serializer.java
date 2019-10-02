package DAL;

import java.io.*;

public class Serializer {

    public void serializeList(SerializableArrayList list, String fileName){

        try(FileOutputStream fileOut = new FileOutputStream(fileName)) {
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(list);
            out.close();
        }
        catch (IOException i){
            // log error
            i.printStackTrace();
        }
    }

    public SerializableArrayList deSerializeList( String fileName){
    SerializableArrayList list = new SerializableArrayList();

        try(FileInputStream fileIn = new FileInputStream(fileName)){
            ObjectInputStream in = new ObjectInputStream(fileIn);
            list = (SerializableArrayList) in.readObject();
            in.close();
        } catch (FileNotFoundException e){
            // do nothing
        }
        catch (IOException e){
            // log error
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            // log error
           e.printStackTrace();
        }

        return list;

    }
}
