CREATE DATABASE IF NOT EXISTS UTFuneral;
USE UTFuneral;

CREATE TABLE IF NOT EXISTS endereco(
                 end_numero INT,
                 end_rua VARCHAR(255),
				 end_cep VARCHAR(20),
                 PRIMARY KEY (end_numero, end_rua, end_cep)
);

CREATE TABLE IF NOT EXISTS servico(
				ser_id INT AUTO_INCREMENT PRIMARY KEY,
                ser_nome VARCHAR(255),
                ser_prestacao DATE,
                ser_preco INT NOT NULL DEFAULT 0,
                ser_tipo VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS produto(
                pro_id INT AUTO_INCREMENT PRIMARY KEY,              
                pro_perecivel BOOLEAN NOT NULL DEFAULT false,
                pro_quant_estoque INT NOT NULL DEFAULT 0,
                pro_preco INT NOT NULL DEFAULT 0
);
                
CREATE TABLE IF NOT EXISTS plano(
                pla_id INT AUTO_INCREMENT PRIMARY KEY,
                pla_preco INT NOT NULL DEFAULT 0
);

CREATE TABLE IF NOT EXISTS plano_produto(
				pla_pro_id INT PRIMARY KEY AUTO_INCREMENT,
				pla_id INT NOT NULL,
                pro_id INT NOT NULL,
                FOREIGN KEY (pla_id) REFERENCES plano(pla_id),
                FOREIGN KEY (pro_id) REFERENCES produto(pro_id)
);

CREATE TABLE IF NOT EXISTS plano_servico(
				pla_ser_id INT PRIMARY KEY AUTO_INCREMENT,
				pla_id INT NOT NULL,
                ser_id INT NOT NULL,
                FOREIGN KEY (pla_id) REFERENCES plano(pla_id),
                FOREIGN KEY (ser_id) REFERENCES servico(ser_id)
);

CREATE TABLE IF NOT EXISTS sala(
                sal_numero INT AUTO_INCREMENT PRIMARY KEY,
                sal_capacidade INT DEFAULT 0
);

CREATE TABLE IF NOT EXISTS defunto(
                def_id INT AUTO_INCREMENT PRIMARY KEY,
                def_nome VARCHAR(255),
                def_data_natalidade DATE,
                def_data_obito DATE,
                def_tipo_obito VARCHAR(100),
                def_cemiterio VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS usuario(
                usu_cpf VARCHAR(50) PRIMARY KEY,
                usu_nome VARCHAR(255) NOT NULL,
                usu_data_natalidade DATE NOT NULL,
                usu_login VARCHAR(100) UNIQUE NOT NULL,
                usu_senha VARCHAR(255) NOT NULL,
                usu_numero_telefone VARCHAR(50) DEFAULT NULL,
                usu_admin BOOLEAN NOT NULL DEFAULT false,
                end_numero INT NOT NULL,
                end_rua VARCHAR(255) NOT NULL,
                end_cep VARCHAR(20) NOT NULL,
                pla_id INT DEFAULT NULL,
                CONSTRAINT fk_usuario_plano
					FOREIGN KEY (pla_id)
                    REFERENCES plano (pla_id),
				CONSTRAINT fk_usuario_endereco
					FOREIGN KEY (end_numero, end_rua, end_cep)
                    REFERENCES endereco (end_numero, end_rua, end_cep)
);

CREATE TABLE IF NOT EXISTS velorio(
                sal_numero INT,
                vel_data_horario DATETIME,
                def_id INT NOT NULL,
                PRIMARY KEY (sal_numero, vel_data_horario),
                CONSTRAINT fk_velorio_sala 
					FOREIGN KEY (sal_numero) REFERENCES sala(sal_numero),
                CONSTRAINT fk_velorio_defunto
					FOREIGN KEY (def_id) REFERENCES defunto(def_id)
);