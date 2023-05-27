# Chess AI - Java with Alpha-Beta Pruning

Chess AI is a program written in Java that implements the alpha-beta pruning algorithm for playing the game of Chess. This AI can be used for studying, simulating games, testing different strategies, or just having a fun opponent to play with.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

Ensure you have the following installed on your local development machine:

- Java JDK 11 or higher
- Apache Maven (Optional: only needed for dependency management and building the project)

### Installation

1. Clone the repository

```sh
git clone https://github.com/kayliese/chess-ai.git
cd chess-ai
```

2. Build the project (if using Maven)

```sh
mvn clean install
```

### Usage

To execute the Chess AI, run the following command:

```sh
java -jar target/chess-ai-<version>.jar
```
Replace `<version>` with the version of the project you have cloned.

## How It Works

This Chess AI makes use of the alpha-beta pruning algorithm, which is a search algorithm that seeks to decrease the number of nodes that are evaluated by the minimax algorithm in its search tree. It is an adversarial search algorithm used commonly for machine playing of two-player games (Tic-tac-toe, Chess, Go, etc.). It stops completely evaluating a move when at least one possibility has been found that proves the move to be worse than a previously examined move. Such moves need not to be evaluated further.

## Contributing

We'd love your help in making Chess AI better. If you find a bug or would like to add a new feature, please create an issue or a pull request.

1. Fork the repository.
2. Create your feature branch (`git checkout -b feature/fooBar`).
3. Commit your changes (`git commit -am 'Add some fooBar'`).
4. Push to the branch (`git push origin feature/fooBar`).
5. Create a new Pull Request.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Contact

Please feel free to reach out to me if you have any questions. You can open an issue on this repository.

Enjoy using Chess AI!

