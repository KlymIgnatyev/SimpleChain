import java.util.Date;

public class Block {
    
    public String hash;
    public String previousHash;
    private String data; // the data will be a single message
    private long timeStamp; // as number of milliseconds since 1/1/1970

    // Block Constructor
    public Block( String data, String previousHash ) {
        this.data = data;
        this.previousHash = previousHash;
        this.timeStamp = new Date().getTime();
        this.hash = calculateHash(); // This has to be done last

    }

    public String calculateHash() {
        String calculateHash = StringUtil.applySha256(
                        previousHash +
                        Long.toString(timeStamp) +
                        data);
        return calculateHash;
    }

}