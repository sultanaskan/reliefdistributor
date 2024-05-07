package distributor.dao;

import java.io.InputStream;
import java.util.List;

public interface GlobalMethodDao {
	//public boolean saveAll(Class<?> entity );
	public void saveFileToFilesystem(String file_directory, String fileName, InputStream inputStream) throws java.io.IOException;
}
