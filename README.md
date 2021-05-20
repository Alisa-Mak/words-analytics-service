# words-analytics-service

### *** RUN ***

1. Download the snapshot `file-analytics-service-0.0.1-SNAPSHOT.jar` from the root directory.
2. Open terminal and navigate to the directory contaning the snapshot.
3. Run the snapshot with command: `java -jar file-analytics-service-0.0.1-SNAPSHOT.jar`
4. Wait till Spring app has started.
5. Open Swagger URL http://localhost:9000/swagger-ui.html 
6. Go to API in Swagger go to `file-analytics-controller` > click on the POST method.
7. Provide an **absolute path** parameter under filePath variable. This is an absolute path to yuor file. Example:`/Users/alisa/Documents/Adaptivist_test_files/sample_file.txt`
8. Press the `try-it-out` button.

### *** ASSUMTIONS ***

1. The file is a small file, for very large files we probably need a more sophisticated solution. 
2. File has no encoding.
3. No special characters present.
4. It's a readable file, the file is not corrupted.
5. The words count soulution provided is case insensitive.
6. File contains some data.
7. File has a standard extension, for my solution, I tested it out on the .txt extension.

### *** NOTES ***

1. Using a post method. It's better to use a GET method in this case, but I couldn't find a way to provide a file path variable to it.
2. The classes are covered with unit tests.
3. No E2E tests were added since this part is usually done by QA.
4. Exceptions are handled by the global exception handler.
