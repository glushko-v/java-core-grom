package lesson19.HomeWork;

public class Controller {

    File[] transferAll(Storage storageFrom, Storage storageTo){

        //1. проверка свободных ячеек
        //2. проверка размера хранилища
        //3. проверка файлов (формат, имя, etc.)
        //4. пробегаем по массиву файлов storageFrom
        //5. если файл не равен null, то пробегаем по массиву storageTo, и, если
        //элемент равет null присваеваем файл из storageTo этому элементу
        File[] filesFrom = storageFrom.getFiles();
        File[] filesTo = storageTo.getFiles();

        for (int i = 0; i <filesFrom.length; i++) {
            if (checkFreeSlots(storageFrom, storageTo)){
                if (filesFrom[i] != null) {
                    for (int j = 0; j <filesTo.length; j++) {
                        if (filesTo[j] == null) {
                            filesTo[j] = checkFile(storageTo, filesFrom[i]);
                            filesFrom[i] = null;
                        }
                    }

                }
            }
        }





        return filesTo;
    }


    File put(Storage storage, File file) {

        File[] files = storage.getFiles();

        checkFile(storage, file);

        for (int i = 0; i < files.length; i++) {
            if (files[i] == null) files[i] = file;
            break;
        }


        return file;
    }


     void delete(Storage storage, File file) {

        for (int i = 0; i < storage.getFiles().length; i++) {
            if (storage.getFiles()[i] != null) {
                if (storage.getFiles()[i].equals(file)) storage.getFiles()[i] = null;

            }
        }
    }

    File findbyId(long id, Storage storage) {
        for (File file : storage.getFiles()) {
            if (file != null) {
                if (id == file.getId()) return file;
            }
        }

        return null;
    }

    boolean checkFormat(Storage storage, File file) {

        for (int i = 0; i < storage.getFormatsSupported().length; i++) {
            if (file.getFormat().equals(storage.getFormatsSupported()[i])) return true;
        }

        return false;
    }

    boolean checkSize(Storage storage, File file) {

        File[] files = storage.getFiles();

        long filesTotalSize = 0;

        for (int i = 0; i <files.length; i++) {
            if (files[i] != null) filesTotalSize += files[i].getSize();
        }
//
        return ((storage.getStorageSize() - filesTotalSize) > file.getSize());

//        return (storage.getStorageSize() >= file.getSize());

    }

    boolean checkFileName(File file) {
        char[] syms = file.getName().toCharArray();
        return (syms.length <= 9);

    }

    boolean checkId(Storage storage, File file) {

        File[] files = storage.getFiles();

        for (File file1 : files) {
            if (file1 != null) {
                if (file1.getId() == file.getId()) return false;
            }
        }
        return true;
    }

    File checkFile(Storage storage, File file){


        if (file == null) return null;
        if (!checkFileName(file)) return null;
        if (!checkSize(storage, file)) return null;
        if (!checkId(storage, file)) return null;
        if (!checkFormat(storage, file)) return null;


        return file;
    }

    int countFiles(Storage storage){
        File[] files = storage.getFiles();
        int count = 0;

        for (File file: files) {
            if (file != null) count++;
        }

        return count;
    }

    int countFreeSlots(Storage storage){
        int count =0;
        File[] files = storage.getFiles();

        for (File file : files) {
            if (file == null) count++;
        }

        return count;
    }

    boolean checkFreeSlots (Storage storageFrom, Storage storageTo){

        return (countFreeSlots(storageTo) >= countFiles(storageFrom));
    }


}