USE HotelDBB;

CREATE TABLE Reservas(
	id_reserva BIGINT IDENTITY(1,1) PRIMARY KEY,
	id_usuario BIGINT NOT NULL,
	id_quarto BIGINT NOT NULL,
	data_entrada DATE NOT NULL,
	data_saida DATE NOT NULL,
	status VARCHAR(20) NOT NULL
	FOREIGN KEY (id_usuario) REFERENCES Usuario(id_usuario),
	FOREIGN KEY (id_quarto) REFERENCES Quartos(id_quarto)
)