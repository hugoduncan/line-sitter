# line-sitter

A tree-sitter based tool for Clojure, using jtreesitter Java bindings.

## Development

### REPL

Start an nREPL server:
```bash
clojure -M:nrepl
```

### Running

```bash
clojure -X:run
```

### Testing

Run tests with kaocha:
```bash
bb test
```

### Code Quality

Format code:
```bash
bb format
```

Check formatting (CI):
```bash
bb format-check
```

Lint with clj-kondo:
```bash
bb lint
```

Import clj-kondo configs from dependencies:
```bash
bb import-kondo-config
```

### Git Hooks

Install pre-commit hooks (auto-formats and lints):
```bash
./scripts/install-hooks.sh
```

## Conventions

- Use semantic commit messages
- Tests use kaocha; place tests in `test/` directory
- Pre-commit hook auto-formats staged files and blocks on lint errors
