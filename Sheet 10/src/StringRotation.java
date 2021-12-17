public class StringRotation {
    private char[] string1, string2;

    public boolean containsString(String string1, String string2) {
        this.string1 = string1.toUpperCase().toCharArray();
        this.string2 = string2.toUpperCase().toCharArray();

        if (this.string1.length <= this.string2.length || string1 == "" || string2 == "") {
            return false;
        }
        char c;
        int k = 0;
        int j = 0;
        for (int i = 0; i < this.string1.length; i++) {
            j = i;
            c = this.string1[j];
            while (c == this.string2[k]) {
                if (k + 1 == this.string2.length) {
                    return true;
                }

                if (j + 1 == this.string1.length) {
                    j = 0;
                    c = this.string1[j];
                    k++;
                } else {
                    j++;
                    k++;
                    c = this.string1[j];

                }
            }
        }

        return false;
    }
}
