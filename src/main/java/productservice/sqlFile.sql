select p1_0.id,
       c1_0.id,
       c1_0.name,
       p1_0.description,
       p1_0.image_url,
       p2_0.id,
       p2_0.currency,
       p2_0.price,
       p1_0.title
from product p1_0
         left join category c1_0 on c1_0.id = p1_0.category_id
         left join price p2_0 on p2_0.id = p1_0.price_id
where p1_0.id = ?