package distributor.daoImpl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;

import com.google.protobuf.Field;
import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

import distributor.dao.GlobalMethodDao;

public class GlobalMethodDaoImpl implements GlobalMethodDao{

	public void saveFileToFilesystem(String file_directory, String fileName,  InputStream inputStream) throws java.io.IOException {
        // Create the output file
        File outputFile = new File(file_directory, fileName);

        // Write the file to the filesystem
        try (FileOutputStream fos = new FileOutputStream(outputFile)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        }
    }

	

}
