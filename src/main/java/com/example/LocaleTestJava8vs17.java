import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class LocaleTestJava8vs17 {
    public static void main(String[] args) {

        Locale enAULocale = new Locale("en", "AU");
        System.out.println("en AU Locale: " + enAULocale);

        Locale enLocale = Locale.ENGLISH;
        System.out.println("Custom Locale: " + enLocale);

        showDateWithCustomFormatAndLocale(enAULocale);
        showDateWithCustomFormatAndLocale(enLocale);
    }

    private static void showDateWithCustomFormatAndLocale(Locale locale) {
        System.out.println("------------ All months with Locale:" + locale + "  ------------");
        for (int i = 1; i <= 12; i++) {
            LocalDate localDate = LocalDate.of(2025, i, 28);
            DateTimeFormatter pattern = DateTimeFormatter.ofPattern("MMM dd, yyyy").withLocale(locale);
            System.out.println(localDate.format(pattern));
        }
    }
}

/*
 * JAVA 17

### 🔍 Differences:

| Month        | `en_AU` Output | `en` Output |
|--------------|----------------|-------------|
| June         | `June`         | `Jun`       |
| July         | `July`         | `Jul`       |
| September    | `Sept`         | `Sep`       |

 *
 *
 * Output: Observe the month in "Sept" is different in both locales
 *
 * Default Locale: en_AU
 * Custom Locale: en
 * ------------ All months with Locale: en_AU  ------------
 * Jan 28, 2025
 * Feb 28, 2025
 * Mar 28, 2025
 * Apr 28, 2025
 * May 28, 2025
 * June 28, 2025
 * July 28, 2025
 * Aug 28, 2025
 * Sept 28, 2025
 * Oct 28, 2025
 * Nov 28, 2025
 * Dec 28, 2025
 * ------------ All months with Locale: en  ------------
 * Jan 28, 2025
 * Feb 28, 2025
 * Mar 28, 2025
 * Apr 28, 2025
 * May 28, 2025
 * Jun 28, 2025
 * Jul 28, 2025
 * Aug 28, 2025
 * Sep 28, 2025
 * Oct 28, 2025
 * Nov 28, 2025
 * Dec 28, 2025
 *
 */

/*
    * JAVA 8
## 🧠 **Key Observation:**
In **Java 8**, both `Locale.ENGLISH` (`en`) and `Locale.forLanguageTag("en-AU")` (`en_AU`) produce **identical abbreviated month names**:
```
Jun, Jul, Sep
```

But in **Java 17**, `en_AU` produces:
```
June, July, Sept
```
while `en` still gives:
```
Jun, Jul, Sep
```

---

## 🔍 **Why This Happens:**

### 1. **Java 17 Uses Updated CLDR Data**
Java 17 relies on newer versions of the Unicode CLDR (Common Locale Data Repository), which contains localized formatting rules. These updates include:
- More accurate or region-specific abbreviations.
- Changes in how months like **September** are abbreviated (`Sept` vs `Sep`).

### 2. **Locale-Specific Customizations**
- `en_AU` (Australian English) prefers **longer or more formal abbreviations**.
- `en` (generic English, often US English) sticks to **standard 3-letter abbreviations**.

---

## ✅ **What You Can Do (If You Need Consistency):**

### Option 1: Force a Specific Format
Use `DateTimeFormatter.ofPattern("MMM d, yyyy", Locale.ENGLISH)` to ensure consistent output.

### Option 2: Normalize Locale
If you want consistent behavior across Java versions, stick to `Locale.ENGLISH` unless region-specific formatting is required.

---

Would you like a sample Java snippet that demonstrates this difference or helps enforce consistent formatting across versions?
 */
