USE HotelDBB;

CREATE TABLE Usuario(
	[id_usuario] BIGINT IDENTITY(1,1) NOT NULL,
	[nome] [varchar](255) NOT NULL,
	[email] [varchar](255) NOT NULL UNIQUE,
	[senha] [varchar](255) NULL,
	[nivel_acesso] [varchar](255) NOT NULL,
	[cpf] [varchar](255) NULL UNIQUE,
	[status_usuario] [varchar](255) NULL,
	[telefone] [varchar](255) NULL,
	[data_nascimento] [date] NULL,
)



