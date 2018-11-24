package Experiment10;

import java.io.*;

public class IOStream {
    class InputClass {
        public void ListAllFileInTheDirectory(String DirectoryPath) {
            if (!DirectoryPath.isEmpty()) {
                try {
                    File open = new File(DirectoryPath);
                    File[] FileList = open.listFiles();
                    System.out.println("Types                  Name                              File Size");
                    for (File EveryFile : FileList) {
                        if (EveryFile.isDirectory()) {
                            System.out.printf("Directory         %-25s                  ---\n", EveryFile.getName());
                        } else if (EveryFile.isFile()) {
                            System.out.printf("File              %-25s                  %.2f KB\n", EveryFile.getName(), (double) EveryFile.length() / 1024.0);
                        }
                    }
                    System.out.println("------------------------------------------------------");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("You must set the correct direcory");
            }
        }
        public void CharReader(String FilePath) {
            if(!FilePath.isEmpty()) {
                int i;
                char c;
                try {
                    Reader f=new FileReader(FilePath);
                    while((i=f.read())!=-1) {
                        c = (char) i;
                        System.out.print(c);
                    }
                    System.out.print("\n");
                    f.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else {
                System.out.println("You must set the correct file path");
            }
        }
        public void BufferReader(String FilePath) {
            if(!FilePath.isEmpty()) {
                try {
                    Reader f=new FileReader(FilePath);
                    char[] buffer=new char[1048];
                    StringBuffer output=new StringBuffer();
                    while(f.read(buffer)!=-1) {
                        String temp=new String(buffer);
                        output.append(temp);
                    }
                    System.out.println(output.toString());
                    f.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else {
                System.out.println("You must set the correct file path");
            }
        }
        public void CharInputStream(String FilePath) {
            if(!FilePath.isEmpty()) {
                int i;
                char c;
                try {
                    InputStream f=new FileInputStream(FilePath);
                    while((i=f.read())!=-1) {
                        c = (char) i;
                        System.out.print(c);
                    }
                    System.out.print("\n");
                    f.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }

            }
            else {
                System.out.println("You must set the correct file path");
            }
        }
        public void BufferInputStream(String FilePath) {
            if(!FilePath.isEmpty()) {
                try {
                    InputStream f=new FileInputStream(FilePath);
                    byte[] buffer=new byte[1048];
                    StringBuffer output=new StringBuffer();
                    while(f.read(buffer)!=-1) {
                        String temp=new String(buffer);
                        output.append(temp);
                    }
                    System.out.println(output.toString());
                    f.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else {
                System.out.println("You must set the correct file path");
            }
        }
    }
    class OutputClass {
        public void CopyImageFile(String SourceFilePath,String DestinationFilePath) {
            if(!SourceFilePath.isEmpty()&&!DestinationFilePath.isEmpty()) {
                InputStream in=null;
                OutputStream out=null;
                try {
                    in=new FileInputStream(SourceFilePath);
                    out=new FileOutputStream(DestinationFilePath);
                    byte[] buffer=new byte[8*1024];
                    while(in.read(buffer)!=-1) {
                        out.write(buffer);
                    }
                    if(in!=null)
                        in.close();
                    if(out!=null)
                        out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else {
                System.out.println("You must set the correct source file path and destination file path");
            }
        }
        public void CopyTextFile(String SourceFilePath,String DestinationFilePath) {
            if(!SourceFilePath.isEmpty()&&!DestinationFilePath.isEmpty()) {
                FileReader in=null;
                FileWriter out=null;
                try {
                    in=new FileReader(SourceFilePath);
                    out=new FileWriter(DestinationFilePath);
                    char[] buffer=new char[8*1024];
                    while(in.read(buffer)!=-1) {
                        out.write(buffer);
                    }
                    if(in!=null)
                        in.close();
                    if(out!=null)
                        out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else {
                System.out.println("You must set the correct source file path and destination file path");
            }
        }
    }
}