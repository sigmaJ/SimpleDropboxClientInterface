import com.dropbox.core.v2.files.Metadata
import java.io.InputStream
import java.io.OutputStream
import java.nio.charset.Charset
import java.nio.charset.StandardCharsets

interface SimpleDropboxClientInterface {
    /**
     * Prepare the dropbox client to make requests.
     * Must be called before any other function
     * @param appKey: your application key, assigned by Dropbox
     * @param identifier: an identifier string.  Arbitrary, but Dropbox suggests including your project name and version
     */
    fun init(appKey: String, identifier: String? = null)

    /**
     * Returns a list of all files in a given directory
     * @param path: directory
     * @return A collection of objects which hold the name, path, and other data about the items in the directory
     */
    fun getFilesInDirectory(path: String): Collection<Metadata>

    /**
     * Outputs a file into the provided OutputStream
     * @param path: file location
     * @param destination: stream to which file will be sent.
     */
    fun getFile(path: String, destination: OutputStream)

    /**
     * Returns the contents of a text file as a String
     * @param path: file location
     * @param charset: Character set to use.  Defaults to UTF_8
     */
    fun getTextFile(path: String, charset: Charset = StandardCharsets.UTF_8): String

    /**
     * Uploads a file from an InputStream
     * @param path: file destination
     * @param source: stream from which file will be read
     */
    fun uploadFile(path: String, source: InputStream)

    /**
     * Uploads a text file
     * @param path: file destination
     * @param contents: String to place in file
     * @param charset: Character set to use.  Defaults to UTF_8
     */
    fun uploadTextFile(path: String, contents: String, charset: Charset = StandardCharsets.UTF_8)

}