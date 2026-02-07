# Valid Phone Numbers

## Problem Description

Given a text file `file.txt` that contains a list of phone numbers (one per line), write a one-liner bash script to print all valid phone numbers.

A valid phone number must be in one of the following formats:

- `(xxx) xxx-xxxx`
- `xxx-xxx-xxxx`

where `x` represents a digit.

## Examples

**Example file.txt:**

```
987-123-4567
123 456 7890
(123) 456-7890
```

**Output:**

```
987-123-4567
(123) 456-7890
```

## Solution Approach

Use `grep` with extended regular expressions (`-E`) to match the two valid formats.

### Regex Breakdown:

- `^` — Start of line
- `\([0-9]{3}\) [0-9]{3}-[0-9]{4}` — Matches `(xxx) xxx-xxxx` format
- `|` — OR
- `[0-9]{3}-[0-9]{3}-[0-9]{4}` — Matches `xxx-xxx-xxxx` format
- `$` — End of line

## Code Structure

```bash
grep -E '^((\([0-9]{3}\) [0-9]{3}-[0-9]{4})|([0-9]{3}-[0-9]{3}-[0-9]{4}))$' file.txt
```
