package com.core.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExDemo {

    /*

    ^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\S+$).{8,}$

    Explanation:
    ^                 # start-of-string
    (?=.*[0-9])       # a digit must occur at least once
    (?=.*[a-z])       # a lower case letter must occur at least once
    (?=.*[A-Z])       # an upper case letter must occur at least once
    (?=.*[@#$%^&+=])  # a special character must occur at least once
    (?=\S+$)          # no whitespace allowed in the entire string
    .{8,}             # anything, at least eight places though
    $                 # end-of-string
      */
    private static final Pattern KEY_HEADER = Pattern.compile(
            "-+BEGIN\\s[^-\\r\\n]*PRIVATE\\s+KEY[^-\\r\\n]*-+(?:\\s|\\r|\\n)+");
    private static final Pattern BODY = Pattern.compile("[a-z0-9+/=][a-z0-9+/=\\r\\n]*", Pattern.CASE_INSENSITIVE);

	/*public static void main(String[] args) {

		String content = "-----BEGIN PRIVATE KEY-----MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQDgni5UcPwEGVmMdixCXHvSWZY2dDotSca16Dy+YZ1sSVPhDx9Sq4nX00Fkpauynfbv8ZamQGr+1yYChc4fLcLK3jU5mcFERFA5MlN+vOiQAUHWNfhnNvBObET7/dtfeH5fSAzauPHP601TA5Kd2vpMbZEzBwz83EGv0UCEQ3OpcOEkAL0wrkL9Hw5DWFfK+jevWLN/VkshkfVZgzXDK6bMhEM9McdnqTnFLhBhgM1sMhaWjfIEbSRbdUkuCMTlPehidrFqi8jSURPFegxWwLxfzBM/XQsNl8lS5f3TgedGD2rt1fha/Ht0/OjvTa6vibSmuhjHuySgVmF1LxywnETlAgMBAAECggEACMEsOG79k5dSrdkpQ8jhAUOBSaFhZxnPXJBZqxNDlHs4gWFv126yJ678hyoMistXWuYao2OICA4QqtvWOybdxxRpaf5RJxJWjMl7sZ6L80OT8lUWLR0EuWRvkowZZxuGKWaLLGHgTY9JQJQMvImoDx8yH+qwGebnydd+YT6pHRB43JURvTkGjg3m0kf4EPGfNy/1Q4couyuyYf/BaThw4XpSS6CGVyopF8ZuU2Xqz26iBGPJYpKRsYO/G6X3lJq3F9zLG02aRKdcKRpV7iT/J1ZZHNXXsW6+Pfv3wUFQOX3TDoOg2C+Zw51keAW5DtueCN5mBXs/7HRAwRd9a9phgQKBgQD4CCPjuF4ZgwNrbHuH2EjMqlxlB6rPPUg7bCeUvhO3qPNG7hn4tEQgj7ndODqrAbpRAYaGuYqwzVltEwWUDjYrHbHpljKc+KcoiueUQjS3NgEhAxGaCIKTSPBX5l2UbxhRMOZSOOg0Xn0q8o2QbLX46DSzQF/LTXcC3J93EZ90hQKBgQDn1XsAMXJLCxVNGRA5hhV09ebHyZNWgmUqPVIzUBMDW8VB3jpSBcKuC3Edw6h270jBkiz1QxJlyG1gwnnDgemJOp/NQ+QWnGYNyteEwqO+LDbwtryjo0GKr9bOU6l4aLdfDr+sbqvAVbCbzbGchAmHpZ9mAisRdf/SDOTq8LAs4QKBgAQnzsIf8qOmyEXieWdbPkz/hbDDoh76vd0RANDDJn1rPTgxAQpjqsiI3+pO6Ny4mLCGwAQ9048GwbrMGMnUOyAZzUNGmu56VAKf4SVgvpVbOEWfUYotHlLtY+l1GJhGDDhAA3vZLDrEYoB3s9t5lsrmyQs/xtsXHylTHPDXwL4pAoGBALQ8lTbuOkQ7ZqEc9i8yniXjMztp7KFaGNqA+BIqk82NoEr4QXEZR2RWQuf4AFYO7AqJ4WgAcCIvc1HBgDbOHkjxCeHkgURO7UyVwX5WcETeTQxRlVDHEKKI2EBqbJvPFZjSd5PQKrkKJZbLkOT1Bg+uZMFCuEcH7Q5ZtfMtklohAoGASLsDk6fV0Ps4IiwtKMS+DUxq8VLmlHA4ly94eFg4m2HlAjvLTOcdoM+BHtSmhlwiwPrZGftI9hm1xOqJ4AFf1g8Q9shB2/eVgBX1ah2vdv8b2zUcLZxcsOxRfCp9yjhR/tlS2xncs57cuVzo4wnkbb1zYnEbt2FerA3/UL3RPQg=-----END PRIVATE KEY-----";
		Matcher m = KEY_HEADER.matcher(content);
		int start = m.end();
		m.usePattern(BODY);
		if (!m.find(start)) {
			System.out.println("Issue with Key!!");
		}


//		extracted();
	}*/
    private static final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
    private Pattern pattern;
    private Matcher matcher;

    public static void main(String[] args) {
        String content = "-----BEGIN PRIVATE KEY-----\nMIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQDgni5UcPwEGVmM\ndixCXHvSWZY2dDotSca16Dy+YZ1sSVPhDx9Sq4nX00Fkpauynfbv8ZamQGr+1yYCh\nc4fLcLK3jU5mcFERFA5MlN+vOiQAUHWNfhnNvBObET7/dtfeH5fSAzauPHP601TA5\nKd2vpMbZEzBwz83EGv0UCEQ3OpcOEkAL0wrkL9Hw5DWFfK+jevWLN/VkshkfVZgzX\nDK6bMhEM9McdnqTnFLhBhgM1sMhaWjfIEbSRbdUkuCMTlPehidrFqi8jSURPFegxW\nwLxfzBM/XQsNl8lS5f3TgedGD2rt1fha/Ht0/OjvTa6vibSmuhjHuySgVmF1Lxywn\nETlAgMBAAECggEACMEsOG79k5dSrdkpQ8jhAUOBSaFhZxnPXJBZqxNDlHs4gWFv12\n6yJ678hyoMistXWuYao2OICA4QqtvWOybdxxRpaf5RJxJWjMl7sZ6L80OT8lUWLR0\nEuWRvkowZZxuGKWaLLGHgTY9JQJQMvImoDx8yH+qwGebnydd+YT6pHRB43JURvTkG\njg3m0kf4EPGfNy/1Q4couyuyYf/BaThw4XpSS6CGVyopF8ZuU2Xqz26iBGPJYpKRs\nYO/G6X3lJq3F9zLG02aRKdcKRpV7iT/J1ZZHNXXsW6+Pfv3wUFQOX3TDoOg2C+Zw5\n1keAW5DtueCN5mBXs/7HRAwRd9a9phgQKBgQD4CCPjuF4ZgwNrbHuH2EjMqlxlB6r\nPPUg7bCeUvhO3qPNG7hn4tEQgj7ndODqrAbpRAYaGuYqwzVltEwWUDjYrHbHpljKc\n+KcoiueUQjS3NgEhAxGaCIKTSPBX5l2UbxhRMOZSOOg0Xn0q8o2QbLX46DSzQF/LT\nXcC3J93EZ90hQKBgQDn1XsAMXJLCxVNGRA5hhV09ebHyZNWgmUqPVIzUBMDW8VB3j\npSBcKuC3Edw6h270jBkiz1QxJlyG1gwnnDgemJOp/NQ+QWnGYNyteEwqO+LDbwtry\njo0GKr9bOU6l4aLdfDr+sbqvAVbCbzbGchAmHpZ9mAisRdf/SDOTq8LAs4QKBgAQn\nzsIf8qOmyEXieWdbPkz/hbDDoh76vd0RANDDJn1rPTgxAQpjqsiI3+pO6Ny4mLCGw\nAQ9048GwbrMGMnUOyAZzUNGmu56VAKf4SVgvpVbOEWfUYotHlLtY+l1GJhGDDhAA3\nvZLDrEYoB3s9t5lsrmyQs/xtsXHylTHPDXwL4pAoGBALQ8lTbuOkQ7ZqEc9i8yniX\njMztp7KFaGNqA+BIqk82NoEr4QXEZR2RWQuf4AFYO7AqJ4WgAcCIvc1HBgDbOHkjx\nCeHkgURO7UyVwX5WcETeTQxRlVDHEKKI2EBqbJvPFZjSd5PQKrkKJZbLkOT1Bg+uZ\nMFCuEcH7Q5ZtfMtklohAoGASLsDk6fV0Ps4IiwtKMS+DUxq8VLmlHA4ly94eFg4m2\nHlAjvLTOcdoM+BHtSmhlwiwPrZGftI9hm1xOqJ4AFf1g8Q9shB2/eVgBX1ah2vdv8\nb2zUcLZxcsOxRfCp9yjhR/tlS2xncs57cuVzo4wnkbb1zYnEbt2FerA3/UL3RPQg=\n-----END PRIVATE KEY-----\n";

        Pattern KEY_HEADER = Pattern.compile(
                "-+BEGIN\\s[^-\\r\\n]*PRIVATE\\s+KEY[^-\\r\\n]*-+(?:\\s|\\r|\\n)+"
        );

        Matcher m = KEY_HEADER.matcher(content);

        if (m.find()) {
            int start = m.end();
            System.out.println("Match found! Start index of key: " + start);
            m.usePattern(BODY);
            if (!m.find(start)) {
                System.out.println("Issue with Key!!");
            } else {
                System.out.println("No Issue with Key!!");
            }
        } else {
            System.out.println("No match found for private key header.");
        }
    }

    private static void extracted() {
        String emailIdRegex = "^[\\w_.]+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}$";
        Pattern pattern = Pattern.compile(emailIdRegex);
        Matcher matcher = pattern.matcher("sjdskjd@gmail.cp");
        System.out.println(matcher.matches());
    }

    /**
     * Validate password with regular expression
     *
     * @param password password for validation
     * @return true valid password, false invalid password
     */
    public boolean validate(final String password) {
        matcher = pattern.matcher(password);
        return matcher.matches();
    }

}