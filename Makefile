up:
	docker-compose up -d

down:
	docker-compose down

build:
	docker-compose up -d --build

nobuild-up:
	docker-compose up -d --no-build

clear:
	docker-compose down
	docker rmi crypto_wallet_wallet
