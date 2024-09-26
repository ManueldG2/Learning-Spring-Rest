

ALTER TABLE `article`
  ADD PRIMARY KEY (`id`),
  ADD KEY `article_category` (`category`),
  ADD KEY `article_warehouse` (`warehouse_id`);

ALTER TABLE `category`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `warehouse`
  ADD PRIMARY KEY (`id`);


ALTER TABLE `article`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

ALTER TABLE `category`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

ALTER TABLE `warehouse`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;


ALTER TABLE `article`
  ADD CONSTRAINT `article_category` FOREIGN KEY (`category`) REFERENCES `category` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `article_warehouse` FOREIGN KEY (`warehouse_id`) REFERENCES `warehouse` (`id`);
